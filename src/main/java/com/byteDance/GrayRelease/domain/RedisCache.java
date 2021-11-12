package com.byteDance.GrayRelease.domain;


import com.byteDance.GrayRelease.infrastructure.pojo.Req;
import com.byteDance.GrayRelease.infrastructure.pojo.RuleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis 缓存,主要方法就是
 * {@link RedisCache#isContains}
 * redis 应配置内存淘汰策略,如果超过指定内存,那么应淘汰最久未使用的键值对
 * @author 陈文杰
 */
@Component
public class RedisCache {

    @Autowired
    RedisTemplate redisTemplate;

    private Character SPILT = '.';

    /**
     * 判断rule的白名单中是否包括req的device_id
     * @param ruleDTO
     * @param req
     * @return
     */
    public boolean isContains(RuleDTO ruleDTO, Req req) {
        Boolean hashKey = redisTemplate.hasKey(getCacheKey(ruleDTO));
        if (!hashKey) {
            return false;
        }
        return Boolean.TRUE.equals(redisTemplate.opsForSet().isMember(getCacheKey(ruleDTO), req.getDevice_id()));
    }

    /**
     * 得到ruleDTO 对应的key值
     * @param ruleDTO
     * @return
     */
    public String getCacheKey(RuleDTO ruleDTO) {
        StringBuilder builder = new StringBuilder();
        String key = builder.append(ruleDTO.getAid()).append(SPILT)
                .append(ruleDTO.getPlatform()).append(SPILT)
                .append(ruleDTO.getCpu_arch()).append(SPILT)
                .toString();
        return key;
    }

    /**
     * 加到redis的set中
     */
    public void add(String[] whiteList,RuleDTO ruleDTO) {
        for (String s : whiteList) {
            redisTemplate.opsForSet().add(getCacheKey(ruleDTO),s);
        }
    }

}
