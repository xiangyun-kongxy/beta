package com.kxy.general.beta.value.constructor;

import com.kxy.general.beta.value.Value;
import com.kxy.general.beta.value.ValueConstructor;
import com.kxy.general.beta.value.mapping.ResourceNameValue;

/**
 * Created by xiangyunkong on 21/04/2017.
 */
public class ResourceNameConstructor implements ValueConstructor {
    private static final long serialVersionUID = 324059197236784342L;

    /**
     * serialize <code>ResourceNameValue</code>.
     * @param value <code>Value</code> to be encoded
     * @return serialized string("")
     */
    @Override
    public String encode(Value value) {
        return "";
    }

    /**
     * deserialize string into <code>ResourceNameValue</code>.
     * @param serialized it should be the result of
     *                   <code>ValueConstructor::encode</code>
     * @return deserialized <code>ResourceNameValue</code>
     */
    @Override
    public Value decode(String serialized) {
        return new ResourceNameValue();
    }
}
