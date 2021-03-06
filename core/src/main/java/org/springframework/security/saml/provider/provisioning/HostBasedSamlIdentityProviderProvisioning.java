/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package org.springframework.security.saml.provider.provisioning;

import org.springframework.security.saml.SamlMetadataCache;
import org.springframework.security.saml.SamlTransformer;
import org.springframework.security.saml.SamlValidator;
import org.springframework.security.saml.provider.config.SamlConfigurationRepository;
import org.springframework.security.saml.provider.identity.IdentityProviderService;
import org.springframework.security.saml.provider.identity.config.LocalIdentityProviderConfiguration;

public class HostBasedSamlIdentityProviderProvisioning
	extends AbstractHostbasedSamlProviderProvisioning
	implements SamlProviderProvisioning<IdentityProviderService> {


	public HostBasedSamlIdentityProviderProvisioning(SamlConfigurationRepository configuration,
													 SamlTransformer transformer,
													 SamlValidator validator,
													 SamlMetadataCache cache) {
		super(configuration, transformer, validator, cache);
	}


	@Override
	public IdentityProviderService getHostedProvider() {
		LocalIdentityProviderConfiguration config =
			getConfigurationRepository().getServerConfiguration().getIdentityProvider();
		return getHostedIdentityProvider(config);
	}


}

