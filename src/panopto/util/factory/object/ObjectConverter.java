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

import java.util.ArrayList;
import java.util.List;

import panopto.resource.Folder;
import panopto.resource.FolderAccessDetail;
import panopto.resource.Group;
import panopto.resource.GroupAccessDetail;
import panopto.resource.RemoteRecorder;
import panopto.resource.RemoteRecorderDevice;
import panopto.resource.Session;
import panopto.resource.SessionAccessDetail;
import panopto.resource.User;
import panopto.resource.UserAccessDetail;
import panopto.resource.collections.impl.GroupAccessDetails;
import panopto.resource.collections.impl.Ids;
import panopto.resource.collections.impl.RemoteRecorderDevices;

public class ObjectConverter
{
    public static Folder getFolder(com.panopto.session.SessionManagementStub.Folder folder)
    {
        com.panopto.session.SessionManagementStub.ArrayOfguid aog = null;
        com.panopto.session.SessionManagementStub.Guid[] guids = null;
        List<String> ids = null;

        Folder pFolder  = new Folder();
        pFolder.setAllowPublicNotes(folder.getAllowPublicNotes());
        pFolder.setAllowSessionDownload(folder.getAllowSessionDownload());
        pFolder.setAudioPodcastITunesUrl(folder.getAudioPodcastITunesUrl());
        pFolder.setAudioRssUrl(folder.getAudioRssUrl());
        try{
            aog = folder.getChildFolders();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pFolder.setChildFolderIds(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        pFolder.setDescription(folder.getDescription());
        pFolder.setEnablePodcast(folder.getEnablePodcast());
        pFolder.setId(folder.getId().getGuid());
        pFolder.setIsPublic(folder.getIsPublic());
        pFolder.setListUrl(folder.getListUrl());
        pFolder.setName(folder.getName());
        try{pFolder.setParentFolder(folder.getParentFolder().getGuid());}catch(Exception e){}
        try{
            aog = folder.getSessions();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pFolder.setSessionIds(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        pFolder.setSettingsUrl(folder.getSettingsUrl());
        pFolder.setVideoPodcastITunesUrl(folder.getVideoPodcastITunesUrl());
        pFolder.setVideoRssUrl(folder.getVideoRssUrl());
        return pFolder;
    }

    public static FolderAccessDetail getFolderAccessDetail(com.panopto.access.AccessManagementStub.FolderAccessDetails folderAccessDetail)
    {
        com.panopto.access.AccessManagementStub.ArrayOfguid aog = null;
        com.panopto.access.AccessManagementStub.Guid[] guids = null;
        List<String> ids = null;

        FolderAccessDetail pFolderAccessDetail = new FolderAccessDetail();
        pFolderAccessDetail.setFolderId(folderAccessDetail.getFolderId().getGuid());
        try{
            aog = folderAccessDetail.getGroupsWithCreatorAccess();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pFolderAccessDetail.setGroupsWithCreatorAccess(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        try{
            aog = folderAccessDetail.getGroupsWithViewerAccess();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pFolderAccessDetail.setGroupsWithViewerAccess(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        pFolderAccessDetail.setIsPublic(folderAccessDetail.getIsPublic());
        try{
            aog = folderAccessDetail.getUsersWithCreatorAccess();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pFolderAccessDetail.setUsersWithCreatorAccess(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        try{
            aog = folderAccessDetail.getUsersWithViewerAccess();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pFolderAccessDetail.setUsersWithViewerAccess(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        return pFolderAccessDetail;
    }

    public static GroupAccessDetail getGroupAccessDetail(com.panopto.access.AccessManagementStub.GroupAccessDetails groupAccessDetail)
    {
        com.panopto.access.AccessManagementStub.ArrayOfguid aog = null;
        com.panopto.access.AccessManagementStub.Guid[] guids = null;
        List<String> ids = null;
        GroupAccessDetail pGroupAccessDetail = new GroupAccessDetail();
        try{
            aog = groupAccessDetail.getFoldersWithCreatorAccess();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pGroupAccessDetail.setFoldersWithCreatorAccess(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        try{
            aog = groupAccessDetail.getFoldersWithViewerAccess();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pGroupAccessDetail.setFoldersWithViewerAccess(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        try{pGroupAccessDetail.setGroupId(groupAccessDetail.getGroupId().getGuid());}catch(Exception e){}
        try{
            aog = groupAccessDetail.getSessionsWithViewerAccess();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pGroupAccessDetail.setSessionsWithViewerAccess(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        pGroupAccessDetail.setSystemRole(groupAccessDetail.getSystemRole().toString());
        return pGroupAccessDetail;
    }
    
    public static Group getGroup(com.panopto.user.UserManagementStub.Group group)
    {
        Group pGroup = new Group();
        pGroup.setExternalId(group.getExternalId());
        pGroup.setGroupType(group.getGroupType().toString());
        try{pGroup.setId(group.getId().getGuid());}catch(Exception e){}
        pGroup.setMembershipProviderName(group.getMembershipProviderName());
        pGroup.setName(group.getName());
        pGroup.setSystemRole(group.getSystemRole().toString());
        return pGroup;
    }

    public static RemoteRecorder getRemoteRecorder(com.panopto.remoterecorder.RemoteRecorderManagementStub.RemoteRecorder remoteRecorder)
    {
        RemoteRecorder pRemoteRecorder = new RemoteRecorder();
        RemoteRecorderDevices rrds = new RemoteRecorderDevices();
        com.panopto.remoterecorder.RemoteRecorderManagementStub.ArrayOfRemoteRecorderDevice aorrd = remoteRecorder.getDevices();
        com.panopto.remoterecorder.RemoteRecorderManagementStub.RemoteRecorderDevice[] rrda = aorrd.getRemoteRecorderDevice();
        for(com.panopto.remoterecorder.RemoteRecorderManagementStub.RemoteRecorderDevice rRD : rrda)
        {
            try{rrds.addRemoteRecorderDevice((RemoteRecorderDevice)PanoptoObjectFactory.getSerializablePanoptoObject(rRD,"RemoteRecorderDevice"));}catch(Exception e){}
        }
        pRemoteRecorder.setDevices(rrds);
        try{pRemoteRecorder.setId(remoteRecorder.getId().getGuid());}catch(Exception e){}
        pRemoteRecorder.setMachineIP(remoteRecorder.getMachineIP());
        pRemoteRecorder.setName(remoteRecorder.getName());
        pRemoteRecorder.setPreviewUrl(remoteRecorder.getPreviewUrl());
        try{
            com.panopto.remoterecorder.RemoteRecorderManagementStub.ArrayOfguid aog = remoteRecorder.getScheduledRecordings();
            com.panopto.remoterecorder.RemoteRecorderManagementStub.Guid[] guids = aog.getGuid();
            List<String> ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pRemoteRecorder.setScheduledRecordings(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        pRemoteRecorder.setSettingsUrl(remoteRecorder.getSettingsUrl());
        pRemoteRecorder.setState(remoteRecorder.getState().toString());
        return pRemoteRecorder;
    }

    public static RemoteRecorderDevice getRemoteRecorderDevice(com.panopto.remoterecorder.RemoteRecorderManagementStub.RemoteRecorderDevice remoteRecorderDevice)
    {
        RemoteRecorderDevice pRemoteRecorderDevice = new RemoteRecorderDevice();
        pRemoteRecorderDevice.setDeviceType(remoteRecorderDevice.getDeviceType().toString());
        pRemoteRecorderDevice.setIsCapturing(remoteRecorderDevice.getIsCapturing());
        pRemoteRecorderDevice.setName(remoteRecorderDevice.getName());
        return pRemoteRecorderDevice;
    }

    public static Session getSession(com.panopto.session.SessionManagementStub.Session session)
    {
        Session pSession = new Session();
        try{pSession.setCreatorId(session.getCreatorId().getGuid());}catch(Exception e){}
        pSession.setDescription(session.getDescription());
        pSession.setDuration(session.getDuration());
        pSession.setEditorUrl(session.getEditorUrl());
        try{pSession.setFolderId(session.getFolderId().getGuid());}catch(Exception e){}
        try{pSession.setId(session.getId().getGuid());}catch(Exception e){}
        pSession.setIsBroadcast(session.getIsBroadcast());
        pSession.setIsDownloadable(session.getIsDownloadable());
        pSession.setMp3Url(session.getMP3Url());
        pSession.setMp4Url(session.getMP4Url());
        pSession.setName(session.getName());
        pSession.setNotesURL(session.getNotesURL());
        pSession.setOutputsPageUrl(session.getOutputsPageUrl());
        try{
            com.panopto.session.SessionManagementStub.ArrayOfguid aog = session.getRemoteRecorderIds();
            com.panopto.session.SessionManagementStub.Guid[] guids = aog.getGuid();
            List<String> ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pSession.setRemoteRecorderIds(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        pSession.setSharePageUrl(session.getSharePageUrl());
        pSession.setStartTime(session.getStartTime());
        pSession.setState(session.getState().toString());
        pSession.setStatusMessage(session.getStatusMessage());
        pSession.setThumbUrl(session.getThumbUrl());
        pSession.setViewerUrl(session.getViewerUrl());
        return pSession;
    }

    public static SessionAccessDetail getSessionAccessDetail(com.panopto.access.AccessManagementStub.SessionAccessDetails sessionAccessDetail)
    {
        com.panopto.access.AccessManagementStub.ArrayOfguid aog = null;
        com.panopto.access.AccessManagementStub.Guid[] guids = null;
        List<String> ids = null;

        SessionAccessDetail pSessionAccessDetail = new SessionAccessDetail();
        try{pSessionAccessDetail.setFolderAccess((FolderAccessDetail)PanoptoObjectFactory.getSerializablePanoptoObject(sessionAccessDetail.getFolderAccess(), "FolderAccessDetail"));}catch(Exception e){}
        try{
            aog = sessionAccessDetail.getGroupsWithDirectViewerAccess();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pSessionAccessDetail.setGroupsWithDirectViewerAccess(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        pSessionAccessDetail.setInheritViewerAccess(sessionAccessDetail.getInheritViewerAccess());
        pSessionAccessDetail.setIsPublic(sessionAccessDetail.getIsPublic());
        try{pSessionAccessDetail.setSessionId(sessionAccessDetail.getSessionId().getGuid());}catch(Exception e){}
        try{
            aog = sessionAccessDetail.getUsersWithDirectViewerAccess();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pSessionAccessDetail.setUsersWithDirectViewerAccess(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        return pSessionAccessDetail;
    }

    public static User getUser(com.panopto.user.UserManagementStub.User user)
    {
        User pUser = new User();
        System.out.println("helllooo");
        pUser.setEmail(user.getEmail());
        pUser.setEmailSessionNotifications(user.getEmailSessionNotifications());
        pUser.setFirstName(user.getFirstName());
        try{
            com.panopto.user.UserManagementStub.ArrayOfguid aog = user.getGroupMemberships();
            com.panopto.user.UserManagementStub.Guid[] guids = aog.getGuid();
            List<String> ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pUser.setGroupMemberships(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        pUser.setLastName(user.getLastName());
        pUser.setSystemRole(user.getSystemRole().toString());
        pUser.setUserBio(user.getUserBio());
        try{pUser.setUserId(user.getUserId().getGuid());}catch(Exception e){}
        pUser.setUserKey(user.getUserKey());
        pUser.setUserSettingsUrl(user.getUserSettingsUrl());
        return pUser;
    }

    public static UserAccessDetail getUserAccessDetail(com.panopto.access.AccessManagementStub.UserAccessDetails userAccessDetail)
    {
        com.panopto.access.AccessManagementStub.ArrayOfguid aog = null;
        com.panopto.access.AccessManagementStub.Guid[] guids = null;
        List<String> ids = null;

        UserAccessDetail pUserAccessDetail = new UserAccessDetail();
        try{
            aog = userAccessDetail.getFoldersWithCreatorAccess();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pUserAccessDetail.setFoldersWithCreatorAccess(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        try{
            aog = userAccessDetail.getFoldersWithViewerAccess();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pUserAccessDetail.setFoldersWithViewerAccess(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        GroupAccessDetails gad = new GroupAccessDetails();
        for(com.panopto.access.AccessManagementStub.GroupAccessDetails groupAccessDetails : userAccessDetail.getGroupMembershipAccess().getGroupAccessDetails())
        {
            try{gad.addGroupAccessDetail((GroupAccessDetail)PanoptoObjectFactory.getSerializablePanoptoObject(gad, "GroupAccessDetail"));}catch(Exception e){}
        }
        pUserAccessDetail.setGroupMembershipAccess(gad);
        try{
            aog = userAccessDetail.getSessionsWithViewerAccess();
            guids = aog.getGuid();
            ids = new ArrayList<String>();
            for(int i=0;i<guids.length;i++){
                ids.add(guids[i].getGuid());
            }
            pUserAccessDetail.setSessionsWithViewerAccess(new Ids(ids.toArray(new String[guids.length])));
        }catch(Exception e){}
        pUserAccessDetail.setSystemRole(userAccessDetail.getSystemRole().toString());
        try{pUserAccessDetail.setUserId(userAccessDetail.getUserId().getGuid());}catch(Exception e){}
        return pUserAccessDetail;
    }
}
