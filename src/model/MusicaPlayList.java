package model;

public class MusicaPlayList {
	int mp_id;
	Musica musica;

	public MusicaPlayList() {
	}
	
	public MusicaPlayList(int mp_id, Musica musica) {
		super();
		this.mp_id = mp_id;
		this.musica = musica;
	}

	public int getMp_id() {
		return mp_id;
	}

	public void setMp_id(int mp_id) {
		this.mp_id = mp_id;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}
	
}
