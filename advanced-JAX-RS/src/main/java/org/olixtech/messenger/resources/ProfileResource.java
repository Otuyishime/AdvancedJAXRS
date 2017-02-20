package org.olixtech.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.olixtech.messenger.model.Profile;
import org.olixtech.messenger.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	// create the profile service instance
	ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfiles(@QueryParam("year") int year, 
			@QueryParam("offset") int offset, @QueryParam("size") int size){
		if( year > 0){
			return profileService.getAllProfilesPerYear(year);
		}
		
		if( offset > 0 && size > 0){
			return profileService.getAllProfilesPaginated(offset, size);
		}
		
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileId}")
	public Profile getProfile(@PathParam("profileId") long profileId){
		return profileService.getProfile(profileId);
	}
	
	@POST
	public Profile addProfile(Profile profile){
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileId}")
	public Profile updateProfile(@PathParam("profileId") long profileId, Profile profile){
		profile.setId(profileId);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileId}")
	public void deleteProfile(@PathParam("profileId") long id){
		profileService.removeprofile(id);
	}
}