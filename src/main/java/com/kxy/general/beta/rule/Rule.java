package com.kxy.general.beta.rule;

import com.kxy.general.beta.resource.Resource;
import com.kxy.general.beta.value.direct.Level;

import java.io.Serializable;

/**
 * Created by xiangyunkong on 14/04/2017.
 */
public interface Rule extends Serializable {
    /**
     * check if the <code>resource</code> matches the <code>Rule</code>. and
     * how much it matches.
     * @param resource <code>Resource</code> to be checked
     * @return how much the <code>Resource</code> matches the <code>Rule</code>
     */
    Level match(Resource resource);
}