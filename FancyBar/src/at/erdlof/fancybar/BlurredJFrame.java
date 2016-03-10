package at.erdlof.fancybar;

import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import com.sun.jna.Native;
import com.sun.jna.Structure;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;

public class BlurredJFrame extends JFrame {
	private static final long serialVersionUID = 9088296895963252630L;
	
	/**
	 * Call this after initializing your window and setting it visible.
	 */
	protected void init() {
		HWND hwnd = new HWND(Native.getWindowPointer(this));
		Dwmapi.DWM_BLURBEHIND pBlurBehind = new Dwmapi.DWM_BLURBEHIND();
		pBlurBehind.dwFlags = Dwmapi.DWM_BB_ENABLE;
		pBlurBehind.fEnable = true;
		pBlurBehind.fTransitionOnMaximized = false;
		Dwmapi.INSTANCE.DwmEnableBlurBehindWindow(hwnd, pBlurBehind);
	}

	// Wrapper for the DWM blur api (JNA das Arschloch)
	public static interface Dwmapi extends StdCallLibrary {
		Dwmapi INSTANCE = (Dwmapi) Native.loadLibrary("Dwmapi", Dwmapi.class, W32APIOptions.UNICODE_OPTIONS);
		
		int DWM_BB_ENABLE = 0x00000001;
		
		boolean DwmEnableBlurBehindWindow(HWND hWnd, DWM_BLURBEHIND pBlurBehind);
		
		public static class DWM_BLURBEHIND extends Structure {
			public int dwFlags;
			public boolean fEnable;
			public IntByReference hRgnBlur;
			public boolean fTransitionOnMaximized;
			
            @SuppressWarnings("rawtypes")
			@Override
            protected List getFieldOrder() {
            	return Arrays.asList("dwFlags", "fEnable", "hRgnBlur", "fTransitionOnMaximized");
            }
		}
	}
}
