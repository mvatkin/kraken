/*
 * Copyright 2011 Future Systems, Inc.
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
package org.krakenapps.dom.msgbus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Requires;
import org.krakenapps.api.PrimitiveConverter;
import org.krakenapps.dom.api.ConfigManager;
import org.krakenapps.dom.api.HostApi;
import org.krakenapps.dom.model.Area;
import org.krakenapps.dom.model.Host;
import org.krakenapps.dom.model.HostType;
import org.krakenapps.msgbus.Request;
import org.krakenapps.msgbus.Response;
import org.krakenapps.msgbus.handler.MsgbusMethod;
import org.krakenapps.msgbus.handler.MsgbusPlugin;

@Component(name = "dom-host-plugin")
@MsgbusPlugin
public class HostPlugin {
	@Requires
	private ConfigManager conf;

	@Requires
	private HostApi hostApi;

	@MsgbusMethod
	public void getHostTypes(Request req, Response resp) {
		Collection<HostType> hostTypes = hostApi.getHostTypes(req.getOrgDomain());
		resp.put("types", PrimitiveConverter.serialize(hostTypes));
	}

	@MsgbusMethod
	public void getHostNames(Request req, Response resp) {
	}

	@MsgbusMethod
	public void getHosts(Request req, Response resp) {
		String areaGuid = req.getString("area_guid");
		Collection<Host> hosts = null;
		if (areaGuid != null) {
			boolean includeChildren = true;
			if (req.has("include_children"))
				includeChildren = req.getBoolean("include_children");

			hosts = hostApi.getHosts(req.getOrgDomain(), areaGuid, includeChildren);
		} else {
			hosts = hostApi.getHosts(req.getOrgDomain());
		}

		if (req.has("filter_name")) {
			List<Host> filtered = new ArrayList<Host>();
			String filterName = req.getString("filter_name");
			for (Host host : hosts) {
				if (host.getName().contains(filterName))
					filtered.add(host);
			}
			resp.put("hosts", PrimitiveConverter.serialize(filtered));
		} else {
			resp.put("hosts", PrimitiveConverter.serialize(hosts));
		}
	}

	@MsgbusMethod
	public void getHost(Request req, Response resp) {
		String guid = req.getString("guid");
		Host host = hostApi.getHost(req.getOrgDomain(), guid);
		resp.put("host", PrimitiveConverter.serialize(host));
	}

	@MsgbusMethod
	public void createHost(Request req, Response resp) {
		Host host = (Host) PrimitiveConverter.overwrite(new Host(), req.getParams(),
				conf.getParseCallback(req.getOrgDomain()));
		hostApi.createHost(req.getOrgDomain(), host);
		resp.put("guid", host.getGuid());
	}

	@MsgbusMethod
	public void updateHost(Request req, Response resp) {
		Host before = hostApi.getHost(req.getOrgDomain(), req.getString("guid"));
		Host host = (Host) PrimitiveConverter.overwrite(before, req.getParams(),
				conf.getParseCallback(req.getOrgDomain()));
		hostApi.updateHost(req.getOrgDomain(), host);
	}

	@MsgbusMethod
	public void removeHost(Request req, Response resp) {
		String guid = req.getString("guid");
		hostApi.removeHost(req.getOrgDomain(), guid);
	}

	@MsgbusMethod
	public void removeHosts(Request req, Response resp) {
		@SuppressWarnings("unchecked")
		Collection<String> guids = (Collection<String>) req.get("guids");
		hostApi.removeHosts(req.getOrgDomain(), guids);
	}
}
