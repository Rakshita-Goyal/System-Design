package MusicPlayerApplication.managers;

import MusicPlayerApplication.device.AudioOutputDevice;
import MusicPlayerApplication.enums.DeviceType;
import MusicPlayerApplication.factories.DeviceFactory;


public class DeviceManager {
private static DeviceManager instance = null;
    private AudioOutputDevice currentOutputDevice;


 private DeviceManager() {
        currentOutputDevice = null;
    }

    public static synchronized DeviceManager getInstance() {
        if (instance == null) {
            instance = new DeviceManager();
        }
        return instance;
    }

       public AudioOutputDevice getOutputDevice() {
        if (currentOutputDevice == null) {
            throw new RuntimeException("No output device is connected.");
        }
        return currentOutputDevice;
    }
 public boolean hasOutputDevice() {
        return currentOutputDevice != null;
    }

     public void connect(DeviceType deviceType) {
        currentOutputDevice = DeviceFactory.createDevice(deviceType);

        switch (deviceType) {
            case BLUETOOTH:
                System.out.println("Bluetooth device connected ");
                break;
            case WIRED:
                System.out.println("Wired device connected ");
                break;
            case HEADPHONES:
                System.out.println("Headphones connected ");
                break;
        }
    }



}