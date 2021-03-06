/**
 * Copyright (C) 2010-2013 Andrei Pozolotin <Andrei.Pozolotin@gmail.com>
 *
 * All rights reserved. Licensed under the OSI BSD License.
 *
 * http://www.opensource.org/licenses/bsd-license.php
 */
package com.carrotgarden.m2e.scr.test.plug.core;

import java.security.Permission;

public class PluginSecurityManager extends SecurityManager {

	private boolean isSandbox;

	@Override
	public void checkPermission(final Permission perm) {
		check(perm);
	}

	@Override
	public void checkPermission(final Permission perm, final Object context) {
		check(perm);
	}

	private void check(final Permission perm) {

		if (!isSandbox) {
			return;
		}

		// I *could* check FilePermission here, but why doesn't
		// URLClassLoader handle it like it says it does?

		throw new SecurityException("Permission denied");

	}

	void enableSandbox() {
		isSandbox = true;
	}

	void disableSandbox() {
		isSandbox = false;
	}

}