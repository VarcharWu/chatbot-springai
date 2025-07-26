package com.example.chatdemo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.chatdemo.entity.Message;
import com.example.chatdemo.mapper.MessageMapper;
import org.springframework.stereotype.Service;

@Service
public class MessageServicelmpl extends ServiceImpl<MessageMapper, Message> implements IMessageService{
}
