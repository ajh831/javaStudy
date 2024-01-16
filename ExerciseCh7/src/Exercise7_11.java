import java.util.Vector;

class MyTv3 {
	boolean isPowerOn;
	int channel;
	int volume;
	Vector<Integer> v = new Vector<Integer>();
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	int getChannel() {
		return this.channel;
	}
	
	int setChannel(int num) {
		this.channel = num;
		v.add(this.channel);
		return this.channel;
	}
	
	int getVolume() {
		return this.volume;
	}
	
	int setVolume(int num) {
		this.volume = num;
		
		return this.volume;
	}
	
	void gotoPrevChannel() {
		int prevCh = v.get(v.size()-2);
		setChannel(prevCh);
	}
}

public class Exercise7_11 {
	public static void main(String[] args) {
		MyTv3 t = new MyTv3();
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setChannel(20);
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:"+t.getChannel());
;	}
}
