/**
 * 
 * Copyright (c) 2006-2017, Speedment, Inc. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at: 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.common.tuple.internal.nonnullable.mapper;

import com.speedment.common.tuple.Tuple1;
import com.speedment.common.tuple.TupleMapper;
import com.speedment.common.tuple.Tuples;
import java.util.function.Function;
import static java.util.Objects.requireNonNull;

/**
 * An implementation class of a {@link TupleMapper } of degree 1
 * 
 * @param <T>  Type of the original object for the mapper to use when creating a
 *             {@code Tuple }
 * @param <T0> type of element 0
 * 
 * @author Per Minborg
 */
public final class Tuple1MapperImpl<T, T0> implements TupleMapper<T, Tuple1<T0>> {
    
    private final Function<T, T0> m0;
    
    /**
     * Constructs a {@link TupleMapper } that can create {@link Tuple1 }.
     * 
     * @param m0 mapper to apply for element 0
     */
    public Tuple1MapperImpl(Function<T, T0> m0) {
        this.m0	=	requireNonNull(m0);
    }
    
    @Override
    public Tuple1<T0> apply(T t) {
        return Tuples.of(
            m0.apply(t)
        );
    }
    
    @Override
    public int degree() {
        return 1;
    }
    
    @Override
    public Function<T, ?> get(int index) {
        switch(index){
            case 0	: return	get0();
            default : throw new IndexOutOfBoundsException();
        }
    }
    
    public Function<T, T0> get0() {
        return m0;
    }
}