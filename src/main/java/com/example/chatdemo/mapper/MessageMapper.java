package com.example.chatdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.chatdemo.entity.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.stream.BaseStream;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {
}
