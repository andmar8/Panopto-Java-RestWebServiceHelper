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
package panopto.util.factory;

public enum PanoptoObjects
{
    Folder,FolderAccessDetail,
    Group,GroupAccessDetail,
    RemoteRecorder,RemoteRecorderDevice,
    Session,SessionAccessDetail,
    User,UserAccessDetail,
    ObjectDoesNotExist;

    public static PanoptoObjects valueOfSafe(String str)
    {
        try
        {
            return valueOf(str);
        }
        catch(Exception e)
        {
            return ObjectDoesNotExist;
        }
    }
}
