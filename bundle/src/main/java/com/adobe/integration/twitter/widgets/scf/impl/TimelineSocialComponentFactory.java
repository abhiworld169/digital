package com.adobe.integration.twitter.widgets.scf.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;

import com.adobe.cq.social.commons.client.api.ClientUtilities;
import com.adobe.cq.social.commons.client.api.QueryRequestInfo;
import com.adobe.cq.social.commons.client.api.SocialComponent;
import com.adobe.cq.social.commons.client.api.SocialComponentFactory;
import com.adobe.cq.social.commons.client.api.AbstractSocialComponentFactory;

@Component
@Service(value = SocialComponentFactory.class)
public class TimelineSocialComponentFactory extends AbstractSocialComponentFactory {
    private static final String TIMELINE_RESOURCE_TYPE = "twitter-integration/components/widgets/scf/timeline";

    public SocialComponent getSocialComponent(Resource resource) {
        return new TimelineSocialComponentImpl(resource, getClientUtilities(resource.getResourceResolver()));
    }

    public SocialComponent getSocialComponent(Resource resource, SlingHttpServletRequest request) {
        return new TimelineSocialComponentImpl(resource, getClientUtilities(request));
    }

    public SocialComponent getSocialComponent(Resource resource, ClientUtilities clientUtilities, QueryRequestInfo queryRequestInfo) {
        return new TimelineSocialComponentImpl(resource, clientUtilities);
    }

    public String getSupportedResourceType() {
        return TimelineSocialComponentFactory.TIMELINE_RESOURCE_TYPE;
    }
}
