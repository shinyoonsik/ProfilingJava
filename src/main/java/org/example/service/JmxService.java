package org.example.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


import com.sun.management.HotSpotDiagnosticMXBean;

import java.io.File;
import java.io.IOException;
import java.lang.management.ManagementFactory;

@Service
public class JmxService {
    private final Logger log = LogManager.getLogger(JmxService.class);

    private HotSpotDiagnosticMXBean mbean;

    public void dumpHeap(String outputFile){
        if(mbean == null){
            try {
                mbean = ManagementFactory.newPlatformMXBeanProxy(
                        ManagementFactory.getPlatformMBeanServer(),
                        "com.sun.management:type=HotSpotDiagnostic",
                        HotSpotDiagnosticMXBean.class
                );
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }

        String myFile = outputFile;
        if(!myFile.endsWith(".hprof")){
            myFile = outputFile + ".hprof";
        }

        try {
            this.mbean.dumpHeap(myFile, true);
            File generatedFile = new File(myFile);
            File newFile = new File(outputFile);
            generatedFile.renameTo(newFile);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
