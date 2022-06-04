package com.graduation.healthservice.service.impl;

import com.graduation.healthservice.domain.Register;
import com.graduation.healthservice.mapper.RegisterMapper;
import com.graduation.healthservice.service.IRegisterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author moyu
 * @since 2022-04-20
 */
@Service
public class RegisterServiceImpl extends ServiceImpl<RegisterMapper, Register> implements IRegisterService {

}
