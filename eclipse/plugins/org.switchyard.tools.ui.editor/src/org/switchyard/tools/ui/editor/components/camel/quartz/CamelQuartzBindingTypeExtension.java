/******************************************************************************* 
 * Copyright (c) 2013 Red Hat, Inc. 
 *  All rights reserved. 
 * This program is made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, 
 * and is available at http://www.eclipse.org/legal/epl-v10.html 
 * 
 * Contributors: 
 * Red Hat, Inc. - initial API and implementation 
 *
 ******************************************************************************/
package org.switchyard.tools.ui.editor.components.camel.quartz;

import java.util.Collections;
import java.util.List;

import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.tb.IImageDecorator;
import org.eclipse.graphiti.tb.ImageDecorator;
import org.eclipse.soa.sca.sca1_1.model.sca.Binding;
import org.switchyard.tools.models.switchyard1_0.camel.quartz.CamelQuartzBindingType;
import org.switchyard.tools.ui.editor.IBindingTypeExtension;
import org.switchyard.tools.ui.editor.ImageProvider;
import org.switchyard.tools.ui.editor.diagram.binding.CreateBindingFeature;
import org.switchyard.tools.ui.editor.diagram.shared.IBindingComposite;

/**
 * CamelQuartzBindingTypeExtension
 * 
 * <p/>
 * Editor extension support Camel Quartz bindings.
 */
public class CamelQuartzBindingTypeExtension implements IBindingTypeExtension {

    @Override
    public ICreateFeature[] newCreateFeatures(IFeatureProvider fp) {
        return new ICreateFeature[] {new CreateBindingFeature(fp, new CamelQuartzBindingFactory(), "Scheduling",
                "A Camel Scheduling based endpoint.", ImageProvider.IMG_16_SCHEDULER) };
    }

    @Override
    public IImageDecorator getImageDecorator(Binding binding) {
        return new ImageDecorator(ImageProvider.IMG_16_SCHEDULER);
    }

    @Override
    public boolean supports(Class<? extends Binding> type) {
        return CamelQuartzBindingType.class.isAssignableFrom(type);
    }

    @Override
    public IBindingComposite createComposite(Binding binding) {
        return new CamelQuartzComposite();
    }

    @Override
    public List<String> getRequiredCapabilities(Binding object) {
        return Collections.singletonList("org.switchyard.components:switchyard-component-camel-quartz");
    }

    @Override
    public String getTypeName(Binding object) {
        return "Scheduling";
    }
}
