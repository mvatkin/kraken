/*
 * Copyright 2010 NCHOVY
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
 package org.krakenapps.sonar.httpheaderparser.parser;

import java.util.ArrayList;
import java.util.List;

import org.krakenapps.bnf.Binding;
import org.krakenapps.bnf.Parser;
import org.krakenapps.sonar.passive.fingerprint.HttpApplicationMetaData;

public class UserAgentParser implements Parser {
	
	//private String extractValueFromBinding( Binding b )
	private List<HttpApplicationMetaData> extractValueFromBinding( Binding b )
	{
		Binding[] children = b.getChildren();
		
		if( children == null )
		{
			List<HttpApplicationMetaData> metaDatas = new ArrayList<HttpApplicationMetaData>();
			metaDatas.add((HttpApplicationMetaData)b.getValue());
			
			return metaDatas; 
			//return (String) b.getValue()+"\n";
		}	
		
		List<HttpApplicationMetaData> metaDatas = new ArrayList<HttpApplicationMetaData>();
		//String strRet="";
		for( Binding child : children )
		{
			for( HttpApplicationMetaData metadata : extractValueFromBinding(child) )
			{
				if( metadata != null )
					metaDatas.add(metadata);
			}
			//strRet += extractValueFromBinding(child);
		}
		
		return metaDatas;
		//return strRet;
	}
	
	@Override
	public Object parse(Binding b) {
		Binding[] children = b.getChildren();
		
		if (children == null || children.length <= 2) {
			return null;
		}
		
		if( children != null && children.length > 2 ){
			return extractValueFromBinding(children[2]);
		}
		
		throw new UnsupportedOperationException();
	}

}
