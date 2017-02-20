package org.olixtech.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.olixtech.messenger.database.DatabaseClass;
import org.olixtech.messenger.model.Profile;

public class ProfileService {

	private Map<Long, Profile> profiles;

	public ProfileService() {
		super();
		profiles = DatabaseClass.getProfiles();

		// create test data
		Profile p1 = new Profile("olivier tuyishime", "olivier", "tuyishime");
		Profile p2 = new Profile("bertrand nsengiyumva", "bertrand", "nsengiyumva");
		Profile p3 = new Profile("patrick kubwimana", "patrick", "kubwimana");
		p1.setId(1L);
		p2.setId(2L);
		p3.setId(3L);
		profiles.put(p1.getId(), p1);
		profiles.put(p2.getId(), p2);
		profiles.put(p3.getId(), p3);
	}

	public List<Profile> getAllProfiles() {
		List<Profile> pfls = new ArrayList<Profile>();
		pfls.addAll(profiles.values());
		return pfls;
	}

	public List<Profile> getAllProfilesPerYear(int year){
		List<Profile> profilesForYear = new ArrayList<Profile>();
		Calendar calendar = Calendar.getInstance();
		for( Profile profile : profiles.values()){
			calendar.setTime(profile.getCreated());
			if(calendar.get(Calendar.YEAR) == year){
				profilesForYear.add(profile);
			}
		}
		
		return profilesForYear;
	}

	public List<Profile> getAllProfilesPaginated(int offset, int size){
		List<Profile> paginatedProfiles = new ArrayList<Profile>(profiles.values());
		if((offset + size) > profiles.size()){
			return new ArrayList<Profile>();
		}
		return paginatedProfiles.subList(offset, offset + size);
	}

	public Profile getProfile(long id) {
		return profiles.get(id);
	}

	public Profile updateProfile(Profile profile) {
		profiles.put(profile.getId(), profile);
		return profiles.get(profile.getId());
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getId(), profile);
		return profiles.get(profile.getId());
	}

	public Profile removeprofile(long id) {
		Profile profile = profiles.remove(id);
		return profile;
	}
}
