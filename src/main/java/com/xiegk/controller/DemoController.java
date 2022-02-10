package com.xiegk.controller;

import com.xiegk.utils.RedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xgk
 * @date 2022/2/10
 */
@Slf4j
@RestController
@RequestMapping("/demos")
public class DemoController {

    @Autowired
    private RedisUtils redisUtils;

    /**
     * set数据
     *
     * @param key     键
     * @param content 内容
     * @return
     */
    @GetMapping("/set/{key}/{content}")
    public String redisClusterSet(@PathVariable("key") String key, @PathVariable("content") String content) {
        boolean setRes = redisUtils.set(key, content);
        return "设置：" + setRes + ", 存储内容：" + content;
    }

    /**
     * get数据
     *
     * @param key 键
     * @return
     */
    @GetMapping("/get/{key}")
    public String redisClusterGet(@PathVariable("key") String key) {
        String content = redisUtils.get(key).toString();
        return "键key: " + key + ", 获取内容：" + content;
    }
}
