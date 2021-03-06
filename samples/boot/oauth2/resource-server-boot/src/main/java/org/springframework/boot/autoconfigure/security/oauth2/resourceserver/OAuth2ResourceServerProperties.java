/*
 * Copyright 2002-2018 the original author or authors.
 *
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
 */

package org.springframework.boot.autoconfigure.security.oauth2.resourceserver;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.security.oauth2.jwt.KeyProvider;

import java.security.PublicKey;

@ConfigurationProperties(prefix = "spring.security.oauth2.resourceserver")
public class OAuth2ResourceServerProperties {
	private IssuerDetails issuer = new IssuerDetails();

	public IssuerDetails getIssuer() {
		return issuer;
	}

	public void setIssuer(IssuerDetails issuer) {
		this.issuer = issuer;
	}

	public static class IssuerDetails {
		private String baseUri;
		private String jwkSetUri;
		private String tokenUri;
		private KeyDetails keys = new KeyDetails();

		public String getBaseUri() {
			return baseUri;
		}

		public void setBaseUri(String baseUri) {
			this.baseUri = baseUri;
		}

		public String getJwkSetUri() {
			return jwkSetUri;
		}

		public void setJwkSetUri(String jwkSetUri) {
			this.jwkSetUri = jwkSetUri;
		}

		public String getTokenUri() {
			return tokenUri;
		}

		public void setTokenUri(String tokenUri) {
			this.tokenUri = tokenUri;
		}

		public KeyDetails getKeys() {
			return keys;
		}

		public void setKeys(KeyDetails keys) {
			this.keys = keys;
		}

		public static class KeyDetails {
			private KeyProvider<PublicKey> signature;

			public KeyProvider<PublicKey> getSignature() {
				return signature;
			}

			public void setSignature(KeyProvider<PublicKey> signature) {
				this.signature = signature;
			}
		}
	}
}
