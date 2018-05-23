/*
 * TeleStax, Open Source Cloud Communications
 * Copyright 2011-2017, Telestax Inc and individual contributors
 * by the @authors tag.
 *
 * This program is free software: you can redistribute it and/or modify
 * under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation; either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package org.mobicents.ussdgateway.management.console.impl;

import org.restcomm.ss7.management.console.CommandContext;
import org.restcomm.ss7.management.console.CommandHandlerWithHelp;
import org.restcomm.ss7.management.console.Tree;
import org.restcomm.ss7.management.console.Tree.Node;

/**
 * @author amit bhayani
 * 
 */
public class UssdCommandHandler extends CommandHandlerWithHelp {

	static final Tree commandTree = new Tree("ussd");
	static {
        Node parent = commandTree.getTopNode();

        Node esme = parent.addChild("scrule");
        esme.addChild("create");
        esme.addChild("modify");
        esme.addChild("delete");
        esme.addChild("show");

        Node set = parent.addChild("set");
        set.addChild("noroutingruleconfigerrmssg");
        set.addChild("servererrmssg");
        set.addChild("dialogtimeouterrmssg");
        set.addChild("ussdgt");
        set.addChild("ussdssn");
        set.addChild("hlrssn");
        set.addChild("mscssn");
        set.addChild("maxmapv");
        set.addChild("cdrloggingto");
        set.addChild("cdrseparator");
        set.addChild("hrhlrgt");

        Node get = parent.addChild("get");
        get.addChild("noroutingruleconfigerrmssg");
        get.addChild("servererrmssg");
        get.addChild("dialogtimeouterrmssg");
        get.addChild("ussdgt");
        get.addChild("ussdssn");
        get.addChild("hlrssn");
        get.addChild("mscssn");
        get.addChild("maxmapv");
        get.addChild("cdrloggingto");
        get.addChild("cdrseparator");
        get.addChild("hrhlrgt");

	};

	public UssdCommandHandler() {
		super(commandTree, CONNECT_MANDATORY_FLAG);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.restcomm.ss7.management.console.CommandHandler#isValid(java.lang
	 * .String)
	 */
	@Override
	public void handle(CommandContext ctx, String commandLine) {
		// TODO Validate command
		if (commandLine.contains("--help")) {
			this.printHelp(commandLine, ctx);
			return;
		}
		
		ctx.sendMessage(commandLine);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.restcomm.ss7.management.console.CommandHandler#isAvailable(org.mobicents
	 * .ss7.management.console.CommandContext)
	 */
	@Override
	public boolean isAvailable(CommandContext ctx) {
		if (!ctx.isControllerConnected()) {
			ctx.printLine("The command is not available in the current context. Please connnect first");
			return false;
		}
		return true;
	}

}
