package cn.happyworlds.imgmt.tools.happypass;

import java.io.Serializable;
import java.util.List;

import cn.happyworlds.imgmt.util.StringUtil;

public abstract class Sector implements Serializable{

	private static final long serialVersionUID = -930171888665535781L;
	
	private byte[] block0;
	private byte[] block1;
	private byte[] block2;
	private byte[] block3;
//	private String block0str;
//	private String block1str;
//	private String block2str;
//	private String block3str;
	private String keyA;
	private String controller;
	private String keyB;

	public byte[] getBlock0() {
		return block0;
	}

	public void setBlock0(byte[] block0) {
		this.block0 = block0;
	}

	public byte[] getBlock1() {
		return block1;
	}

	public void setBlock1(byte[] block1) {
		this.block1 = block1;
	}

	public byte[] getBlock2() {
		return block2;
	}

	public void setBlock2(byte[] block2) {
		this.block2 = block2;
	}

	public byte[] getBlock3() {
		return block3;
	}

	public void setBlock3(byte[] block3) {
		this.block3 = block3;
	}

	public String getBlock0Str() {
		return Codec.hexEncode(block0);
	}

	public void setBlock0(String block0) {
		this.block0 = Codec.hexDecode(block0);
	}

	public String getBlock1Str() {
		return Codec.hexEncode(block1);
	}

	public void setBlock1(String block1) {
		this.block1 = Codec.hexDecode(block1);
	}

	public String getBlock2Str() {
		return Codec.hexEncode(block2);
	}

	public void setBlock2(String block2) {
		this.block2 = Codec.hexDecode(block2);
	}

	public String getBlock3Str() {
		return Codec.hexEncode(block3);
	}

	public void setBlock3(String block3) {
		this.block3 = Codec.hexDecode(block3);
	}

	public String getKeyA() {
		return keyA;
	}

	public void setKeyA(String keyA) {
		this.keyA = keyA;
	}

	public String getController() {
		return controller;
	}

	public void setController(String controller) {
		this.controller = controller;
	}

	public String getKeyB() {
		return keyB;
	}

	public void setKeyB(String keyB) {
		this.keyB = keyB;
	}
	
//	public String getBlock0str() {
//		if(block0str==null)
//			block0str = Codec.hexEncode(block0);
//		return block0str;
//	}
//
//	public String getBlock1str() {
//		if(block1str==null)
//			block1str = Codec.hexEncode(block1);
//		return block1str;
//	}
//
//	public String getBlock2str() {
//		if(block2str==null)
//			block2str = Codec.hexEncode(block2);
//		return block2str;
//	}
//
//	public String getBlock3str() {
//		if(block3str==null)
//			block3str = Codec.hexEncode(block3);
//		return block3str;
//	}


	protected abstract Sector buildBlocks();
	protected abstract Sector parseBlocks(List<String> blockstr);
	
	protected void buildBlock3(){
		if(StringUtil.hasText(getKeyA())&&
			StringUtil.hasText(getController())&&
			StringUtil.hasText(getKeyB())){
			byte block3[] = new byte[16];
			System.arraycopy(Codec.bcdDecode(getKeyA(), 12), 0, block3, 0, 6);
			System.arraycopy(Codec.bcdDecode(getController(), 8), 0, block3, 6, 4);
			System.arraycopy(Codec.bcdDecode(getKeyB(), 12), 0, block3, 10, 6);
			
			setBlock3(block3);
		}
	}

	protected byte calcCheckbit(byte[] bytes) {
		int checkbit = bytes[0] ^ bytes[1];
		for (int i = 2; i < 15; i++) {
			checkbit = checkbit ^ bytes[i];
		}
		return (byte) checkbit;
	}
	protected boolean checkbit(String str){
		byte []bytes = Codec.bcdDecode(str);
		int checkbit = bytes[0] ^ bytes[1];
		for (int i = 2; i < 15; i++) {
			checkbit = checkbit ^ bytes[i];
		}
		return bytes[15] == checkbit;
	}
}
