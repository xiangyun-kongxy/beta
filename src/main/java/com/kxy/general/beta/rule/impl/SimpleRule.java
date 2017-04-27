package com.kxy.general.beta.rule.impl;

import com.kxy.general.beta.relation.Relation;
import com.kxy.general.beta.resource.Resource;
import com.kxy.general.beta.rule.Rule;
import com.kxy.general.beta.value.Value;
import com.kxy.general.beta.value.direct.Level;
import com.kxy.general.beta.value.exception.NoSuchAddress;
import com.kxy.general.beta.value.exception.ParameterTypeMissMatch;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <code>SimpleRule</code> use relationship between <code>Value</code>s to
 * mention the rule. for example:
 *      <code>SimpleRule(Greater.class, ResourceAddressValue("vcpu"),
 *      Level(4))</code>
 * means the resource should contain more than 4 vcpu.
 *
 * Created by xiangyunkong on 14/04/2017.
 */
public class SimpleRule implements Rule {
    private static final long serialVersionUID = 6378203051307630516L;

    /**
     * relation/operator to mention relationship between one or more
     * <code>Value</code>s.
     */
    @Getter
    private Relation relation;

    /**
     * <code>Value</code>s to be mentioned in the relation.
     */
    @Getter
    private List<Value> values = new ArrayList<>();

    /**
     * init <code>SimpleRule</code> by relation and values.
     * @param relation relation of the values
     * @param values values to be operate
     */
    public SimpleRule(Relation relation, Value... values) {
        this.relation = relation;
        this.values.addAll(Arrays.asList(values));
    }

    /**
     * @see Rule#match(Resource)
     * @param resource <code>Resource</code> to be checked
     * @return if and how much the resource matches the relation
     */
    public Level match(Resource resource) {
        final List<Value> param = new ArrayList<>();
        values.forEach(value -> {
            try {
                param.add(value.get(resource));
            } catch (ParameterTypeMissMatch | NoSuchAddress e) {
                e.printStackTrace();
            }
        });

        return relation.compare(param);
    }
}
