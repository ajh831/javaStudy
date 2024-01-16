class MyTv2 {
	boolean isPowerOn;
	int channel;
	int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	int getChannel() {
		return this.channel;
	}
	
	int setChannel(int num) {
		this.channel = num;
		return this.channel;
	}
	
	int getVolume() {
		return this.volume;
	}
	
	int setVolume(int num) {
		this.volume = num;
		
		return this.volume;
	}
}

public class Exercise7_10 {
	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		
		t.setChannel(10);
		System.out.println("CH:"+t.getChannel());
		t.setVolume(20);
		System.out.println("VOL:"+t.getVolume());
	}
}
