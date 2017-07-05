package model;

public class UserPlayList {
	private int upId;
	PlayList playlist;
	
	public UserPlayList() {
	}
	
	public UserPlayList(int upId, PlayList playlist) {
		super();
		this.upId = upId;
		this.playlist = playlist;
	}
	
	public int getUpId() {
		return upId;
	}
	public void setUpId(int upId) {
		this.upId = upId;
	}
	public PlayList getPlaylist() {
		return playlist;
	}
	public void setPlaylist(PlayList playlist) {
		this.playlist = playlist;
	}
	
}
