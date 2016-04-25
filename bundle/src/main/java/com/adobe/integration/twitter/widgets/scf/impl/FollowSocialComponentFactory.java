package com.adobe.integration.twitter.widgets.scf.impl;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;

import com.adobe.cq.social.commons.client.api.ClientUtilities;
import com.adobe.cq.social.commons.client.api.QueryRequestInfo;
import com.adobe.cq.social.commons.client.api.SocialComponent;
import com.adobe.cq.social.commons.client.api.SocialComponentFactory;

@Component
@Service(value = SocialComponentFactory.class)
public class FollowSocialComponentFactory extends com.adobe.cq.social.commons.client.api.AbstractSocialComponentFactory {
    private static final String FOLLOW_RESOURCE_TYPE = "twitter-integration/components/widgets/scf/follow";

    public SocialComponent getSocialComponent(Resource resource) {
        return new FollowSocialComponentImpl(resource, getClientUtilities(resource.getResourceResolver()));
    }

    public SocialComponent getSocialComponent(Resource resource, SlingHttpServletRequest request) {
        return new FollowSocialComponentImpl(resource, getClientUtilities(request));
    }

    public SocialComponent getSocialComponent(Resource resource, ClientUtilities clientUtilities, QueryRequestInfo queryRequestInfo) {
        return new FollowSocialComponentImpl(resource, clientUtilities);
    }

    public String getSupportedResourceType() {
        return FollowSocialComponentFactory.FOLLOW_RESOURCE_TYPE;
    }

}
