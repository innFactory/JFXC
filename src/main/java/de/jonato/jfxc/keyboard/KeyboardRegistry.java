package de.jonato.jfxc.keyboard;

/*
 * #%L
 * JFXC
 * %%
 * Copyright (C) 2016 Jonato IT Solutions
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.util.HashMap;

/**
 * Save a Keyboard in a central registry.
 */
public class KeyboardRegistry {

    private static HashMap<String, IKeyboard> registry = new HashMap<>();

    /**
     * Save a Keyboard Instance to a given name.
     * @param name identifier
     * @param keyboard keyboard instance
     */
    public static void add(String name, IKeyboard keyboard){
        registry.put(name, keyboard);
    }

    /**
     * Get a Keyboard Instance by a given name.
     * @param name identifier
     * @return keyboard instance
     */
    public static IKeyboard get(String name){
        if(registry.containsKey(name)){
            return registry.get(name);
        }else{
            throw new IllegalArgumentException("Keyboard instance not found in registry.");
        }
    }

}
