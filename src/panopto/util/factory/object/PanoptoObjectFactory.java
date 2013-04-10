/*
 * This file is part of Panopto-Java-RestWebServiceHelper.
 * 
 * Panopto-Java-RestWebServiceHelper is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Panopto-Java-RestWebServiceHelper is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Panopto-Java-RestWebServiceHelper.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright: Andrew Martin, Newcastle University
 * 
 */
package panopto.util.factory.object;

import com.panopto.access.AccessManagementStub.FolderAccessDetails;
import com.panopto.access.AccessManagementStub.GroupAccessDetails;
import com.panopto.access.AccessManagementStub.SessionAccessDetails;
import com.panopto.access.AccessManagementStub.UserAccessDetails;
import com.panopto.remoterecorder.RemoteRecorderManagementStub.RemoteRecorder;
import com.panopto.remoterecorder.RemoteRecorderManagementStub.RemoteRecorderDevice;
import com.panopto.session.SessionManagementStub.Folder;
import com.panopto.session.SessionManagementStub.Session;
import com.panopto.user.UserManagementStub.Group;
import com.panopto.user.UserManagementStub.User;
import panopto.util.factory.PanoptoObjects;

public class PanoptoObjectFactory
{
    public static Object getSerializablePanoptoObject(Object o, String type) throws Exception
    {
        switch(PanoptoObjects.valueOfSafe(type))
        {
            case Folder: return ObjectConverter.getFolder((Folder)o);
            case FolderAccessDetail: return ObjectConverter.getFolderAccessDetail((FolderAccessDetails)o);
            case Group: return ObjectConverter.getGroup((Group)o);
            case GroupAccessDetail: return ObjectConverter.getGroupAccessDetail((GroupAccessDetails)o);
            case RemoteRecorder: return ObjectConverter.getRemoteRecorder((RemoteRecorder)o);
            case RemoteRecorderDevice: return ObjectConverter.getRemoteRecorderDevice((RemoteRecorderDevice)o);
            case Session: return ObjectConverter.getSession((Session)o);
            case SessionAccessDetail: return ObjectConverter.getSessionAccessDetail((SessionAccessDetails)o);
            case User: return ObjectConverter.getUser((User)o);
            case UserAccessDetail: return ObjectConverter.getUserAccessDetail((UserAccessDetails)o);
            default: throw new Exception("Type '"+type+"' not found");
        }
    }
}
