package com.hb0730.boot.admin.commons.domain.controller;

import com.hb0730.boot.admin.commons.domain.BusinessDomain;
import com.hb0730.boot.admin.commons.domain.service.IBaseService;

/**
 * @author bing_huang
 * @date 2020/07/15 9:16
 * @since V1.0
 */
@SuppressWarnings({"rawtypes"})
public interface IBaseController<ENTITY extends BusinessDomain> {
    /**
     * 获取实体的类型
     */
    Class<ENTITY> getEntityClass();

    /**
     * 获取service
     *
     * @return service
     */
    IBaseService getBaseService();
}
