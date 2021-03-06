/*******************************************************************************
 * Copyright 2013 Mojave Innovations GmbH
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Contributors:
 *     Mojave Innovations GmbH - initial API and implementation
 ******************************************************************************/
package org.entirej.framework.core.properties.definitions.interfaces;

public interface EJNotifiablePropertyDefinition
{
    /**
     * Returns the name of this definition
     * 
     * @return The definition name
     */
    public String getName();
    
    /**
     * When set to <code>true</code>, the EntireJ Plugin will inform the
     * FrameworkExtension Definition that this property has changed
     */
    public void setNotifyWhenChanged(boolean notify);
    
    /**
     * Indicates if the EntireJ Plugin will inform the Framework Extension
     * Definition when this property has changed
     * 
     * @return <code>true</code> when changes will be notified, otherwise
     *         <code>false</code>
     */
    public boolean notifyWhenChanged();
}
