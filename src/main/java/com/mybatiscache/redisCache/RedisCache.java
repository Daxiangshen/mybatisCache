package com.mybatiscache.redisCache;

import com.mybatiscache.utils.SpringContextHolder;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * RedisCache Class
 *
 * @author yuxiang
 * @since 2019/7/10
 * */
public class RedisCache implements Cache {

    private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    /**
     * cache instance(实例) id
     * */
    private final String id;


    private RedisTemplate redisTemplate=SpringContextHolder.getBean("redisTemplate");

    /**
     * redis过期时间
     * */
    private static final long EXPIRE_TIME_IN_MINUTES = 30;

    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    /**
     * mybatis缓存操作对象的标识符。一个mapper对应一个mybatis的缓存操作对象
     * */
    @Override
    public String getId() {
        return id;
    }

    /**
     * 将查询结果塞入缓存
     *
     * @param key
     * @param value
     */
    @Override
    @SuppressWarnings("unchecked")
    public void putObject(Object key, Object value) {
        ValueOperations opsForValue = redisTemplate.opsForValue();
        opsForValue.set(key, value, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);
        logger.debug("Put query result to redis");
    }

    /**
     * 从缓存中获取被缓存的查询结果
     *
     * @param key
     * @return
     */
    @Override
    public Object getObject(Object key) {
        ValueOperations opsForValue = redisTemplate.opsForValue();
        logger.debug("Get cached query result from redis");
        return opsForValue.get(key);
    }

    /**
     * 从缓存中删除对应的key、value。只有在回滚时触发。一般我们也可以不用实现，具体使用方式请参考：org.apache.iBatis.cache.decorators.TransactionalCache
     *
     * @param key
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object removeObject(Object key) {
        redisTemplate.delete(key);
        logger.debug("Remove cached query result from redis");
        return null;
    }

    /**
     * 发生更新时，清除缓存
     * */
    @Override
    public void clear() {
        redisTemplate.execute((RedisCallback) connection -> {
            connection.flushDb();
            return null;
        });
        logger.debug("Clear all the cached query result from redis");
    }

    /**
     * 可选实现。返回缓存的数量
     * */
    @Override
    public int getSize() {
        return 0;
    }

    /**
     * 可选实现。用于实现原子性的缓存操作
     * */
    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }




    /**
     * 笔记：
     *
     * 这里不能通过autowire的方式引用redisTemplate，因为RedisCache并不是Spring容器里的bean。所以我们需要手动地去调用容器的getBean方法来拿到这个bean
     * 参考utils里的SpringContextHolder类
     *
     * @SuppressWarnings("unchecked")是忽略警告的注解
     *
     * 我们采用的redis序列化方式是默认的jdk序列化。所以数据库的查询对象（比如Product类）需要实现Serializable接口
     * */
}
