package com.kxy.general.beta.value.constructor;

import com.kxy.general.beta.value.Value;
import com.kxy.general.beta.value.ValueConstructor;
import com.kxy.general.beta.value.direct.Level;

/**
 *
 * Created by xiangyunkong on 20/04/2017.
 */
public class LevelConstructor implements ValueConstructor {
    private static final long serialVersionUID = 9069854697759710346L;

    /**
     * encoding type Level.
     * @param value Value to be encoded
     * @return the encoded string
     */
    @Override
    public String encode(Value value) {
        if (value instanceof Level) {
            Level level = (Level) value;
            return level.getValue().toString();
        } else {
            return null;
        }
    }

    /**
     * decoding type Level.
     * @param serialized it should be the result of ValueConstructor::encode
     * @return the decoded Level object
     */
    @Override
    public Value decode(String serialized) {
        return new Level(Long.valueOf(serialized));
    }
}
