/*
 * Copyright 2011 Future Systems
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.krakenapps.radius.protocol;

public class ChapChallengeAttribute extends RadiusAttribute {

	private byte[] challenge;

	public ChapChallengeAttribute(byte[] challenge) {
		this.challenge = challenge;
	}

	public ChapChallengeAttribute(byte[] encoded, int offset, int length) {
		if (encoded[offset] != 60)
			throw new IllegalArgumentException("binary is not chap challenge attribute");

		this.challenge = decodeString(encoded, offset, length);
	}
	
	public byte[] getChallenge() {
		return challenge;
	}

	@Override
	public byte[] getBytes() {
		return encodeString(60, challenge);
	}
}
