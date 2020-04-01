package com.murphy233.mall.service;

/**
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 *
 * @author zhangyh2360@dimpt.com
 * @date 2020/4/1 10:28 下午
 */
public interface RedisService {
    /**
     * 存储数据
     *
     * @param key 键
     * @param value 值
     */
    void set(String key, String value);

    /**
     * 获取数据
     *
     * @param key 键
     * @return 值
     */
    String get(String key);

    /**
     * 设置超期时间
     *
     * @param key 键
     * @param expire 超时时间
     * @return 是否设置成功
     */
    Boolean expire(String key, long expire);

    /**
     * 删除数据
     *
     * @param key 键
     */
    void remove(String key);

    /**
     * 自增操作
     *
     * @param key 键
     * @param delta 自增步长
     * @return 自增结果
     */
    Long increment(String key, long delta);

}
