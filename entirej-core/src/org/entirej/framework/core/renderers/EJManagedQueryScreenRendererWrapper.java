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
package org.entirej.framework.core.renderers;

import java.io.Serializable;

import org.entirej.framework.core.EJApplicationException;
import org.entirej.framework.core.EJFrameworkManager;
import org.entirej.framework.core.data.EJDataRecord;
import org.entirej.framework.core.data.controllers.EJBlockController;
import org.entirej.framework.core.data.controllers.EJLovController;
import org.entirej.framework.core.enumerations.EJManagedScreenProperty;
import org.entirej.framework.core.interfaces.EJScreenItemController;
import org.entirej.framework.core.properties.EJCoreQueryScreenItemProperties;
import org.entirej.framework.core.renderers.interfaces.EJQueryScreenRenderer;
import org.entirej.framework.core.renderers.registry.EJQueryScreenItemRendererRegister;

public class EJManagedQueryScreenRendererWrapper implements Serializable
{
    private EJFrameworkManager    _frameworkManager;
    private EJQueryScreenRenderer _renderer;
    
    public EJManagedQueryScreenRendererWrapper(EJFrameworkManager manager, EJQueryScreenRenderer renderer)
    {
        _frameworkManager = manager;
        _renderer = renderer;
    }
    
    public EJQueryScreenRenderer getUnmanagedRenderer()
    {
        return _renderer;
    }
    
    public EJQueryScreenItemRendererRegister getItemRegister()
    {
        try
        {
            return _renderer.getItemRegister();
        }
        catch (Exception e)
        {
            handleException(e);
            return null;
        }
    }
    
    public EJDataRecord getQueryRecord()
    {
        try
        {
            return _renderer.getQueryRecord();
        }
        catch (Exception e)
        {
            handleException(e);
            return null;
        }
    }
    
    public void initialiseRenderer(EJBlockController block)
    {
        try
        {
            _renderer.initialiseRenderer(block);
        }
        catch (Exception e)
        {
            handleException(e);
        }
    }
    
    public void initialiseRenderer(EJLovController controller)
    {
        try
        {
            _renderer.initialiseRenderer(controller);
        }
        catch (Exception e)
        {
            handleException(e);
        }
    }
    
    public void open(EJDataRecord queryRecord)
    {
        try
        {
            _renderer.open(queryRecord);
        }
        catch (Exception e)
        {
            handleException(e);
        }
    }
    
    public void close()
    {
        try
        {
            _renderer.close();
        }
        catch (Exception e)
        {
            handleException(e);
        }
    }
    
    public void refreshItemProperty(EJCoreQueryScreenItemProperties itemProperties, EJManagedScreenProperty managedItemProperty)
    {
        try
        {
            _renderer.refreshItemProperty(itemProperties, managedItemProperty);
        }
        catch (Exception e)
        {
            handleException(e);
        }
    }
    
    public void refreshQueryScreenRendererProperty(String propertyName)
    {
        try
        {
            _renderer.refreshQueryScreenRendererProperty(propertyName);
        }
        catch (Exception e)
        {
            handleException(e);
        }
    }
    
    public void refreshAfterChange(EJDataRecord record)
    {
        try
        {
            _renderer.refreshAfterChange(record);
        }
        catch (Exception e)
        {
            handleException(e);
        }
    }
    
    public void synchronize()
    {
        try
        {
            _renderer.synchronize();
        }
        catch (Exception e)
        {
            handleException(e);
        }
    }
    
    public Object getGuiComponent()
    {
        try
        {
            return _renderer.getGuiComponent();
        }
        catch (Exception e)
        {
            handleException(e);
            return null;
        }
    }
    
    /**
     * Returns an item with the given name
     * 
     * @param itemName
     *            The name of the required item
     */
    public EJScreenItemController getItem(String itemName)
    {
        try
        {
            EJScreenItemController screenItem = _renderer.getItem(itemName);
            if (screenItem == null)
            {
                handleException(new IllegalArgumentException("Unable to find item " + itemName + " on query screen."));
                return null;
            }
            return screenItem;
        }
        catch (Exception e)
        {
            handleException(e);
            return null;
        }
    }
    
    private void handleException(Exception e)
    {
        if (e instanceof EJApplicationException)
        {
            _frameworkManager.handleException((EJApplicationException) e);
        }
        else
        {
            _frameworkManager.handleException(new EJApplicationException(e));
        }
    }
}
