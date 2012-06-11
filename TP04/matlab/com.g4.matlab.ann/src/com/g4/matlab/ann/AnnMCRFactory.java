/*
 * MATLAB Compiler: 4.13 (R2010a)
 * Date: Mon Jun 11 11:26:49 2012
 * Arguments: "-B" "macro_default" "-W" "java:com.g4.matlab.ann,ANN" "-T" "link:lib" "-d" 
 * "/Users/macarse/Documents/sia2012/TP04/matlab/com.g4.matlab.ann/src" "-w" 
 * "enable:specified_file_mismatch" "-w" "enable:repeated_file" "-w" 
 * "enable:switch_ignored" "-w" "enable:missing_lib_sentinel" "-w" "enable:demo_license" 
 * "-v" 
 * "class{ANN:/Users/macarse/Documents/sia2012/TP02/TPE2/backpropagation.m,/Users/macarse/Documents/sia2012/TP02/TPE2/createIndividual.m,/Users/macarse/Documents/sia2012/TP02/TPE2/evalANN.m,/Users/macarse/Documents/sia2012/TP02/TPE2/generateInputFromFile.m}" 
 */

package com.g4.matlab.ann;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;

/**
 * <i>INTERNAL USE ONLY</i>
 */
public class AnnMCRFactory
{
    /** Application key data */
    private static final byte[] sSessionKey = 
        { 67, 52, 51, 50, 68, 50, 67, 70, 53, 56, 65, 55, 68, 50, 54, 54, 70, 66, 57, 56, 
        48, 70, 48, 68, 69, 54, 51, 50, 68, 67, 65, 67, 68, 56, 52, 51, 51, 50, 65, 55, 
        48, 70, 56, 68, 68, 70, 65, 56, 66, 52, 66, 67, 51, 70, 57, 51, 56, 65, 68, 52, 
        50, 57, 49, 65, 56, 69, 65, 51, 70, 66, 67, 70, 55, 68, 70, 68, 54, 48, 48, 67, 
        66, 51, 48, 51, 66, 57, 69, 56, 69, 52, 50, 54, 57, 51, 56, 65, 57, 70, 52, 48, 
        67, 52, 54, 49, 67, 48, 67, 52, 53, 69, 52, 54, 52, 57, 49, 68, 50, 49, 57, 70, 
        70, 66, 51, 66, 49, 68, 70, 68, 57, 48, 53, 48, 66, 52, 70, 54, 56, 49, 54, 49, 
        70, 67, 57, 70, 49, 57, 53, 53, 53, 57, 70, 70, 53, 53, 55, 66, 51, 56, 50, 69, 
        54, 57, 69, 53, 66, 66, 54, 50, 57, 68, 54, 54, 53, 70, 70, 68, 69, 66, 57, 68, 
        51, 56, 48, 54, 48, 49, 65, 48, 51, 68, 55, 66, 65, 56, 56, 67, 55, 55, 67, 50, 
        51, 68, 65, 69, 53, 66, 56, 50, 57, 65, 67, 66, 49, 70, 70, 67, 55, 65, 69, 52, 
        56, 54, 54, 50, 70, 55, 48, 69, 49, 57, 66, 56, 69, 67, 70, 67, 56, 50, 65, 54, 
        50, 70, 56, 52, 51, 51, 54, 48, 57, 66, 54, 50, 49, 56, 49, 56 };
    
    /** Public key data */
    private static final byte[] sPublicKey = 
        { 51, 48, 56, 49, 57, 68, 51, 48, 48, 68, 48, 54, 48, 57, 50, 65, 56, 54, 52, 56, 
        56, 54, 70, 55, 48, 68, 48, 49, 48, 49, 48, 49, 48, 53, 48, 48, 48, 51, 56, 49, 
        56, 66, 48, 48, 51, 48, 56, 49, 56, 55, 48, 50, 56, 49, 56, 49, 48, 48, 67, 52, 
        57, 67, 65, 67, 51, 52, 69, 68, 49, 51, 65, 53, 50, 48, 54, 53, 56, 70, 54, 70, 
        56, 69, 48, 49, 51, 56, 67, 52, 51, 49, 53, 66, 52, 51, 49, 53, 50, 55, 55, 69, 
        68, 51, 70, 55, 68, 65, 69, 53, 51, 48, 57, 57, 68, 66, 48, 56, 69, 69, 53, 56, 
        57, 70, 56, 48, 52, 68, 52, 66, 57, 56, 49, 51, 50, 54, 65, 53, 50, 67, 67, 69, 
        52, 51, 56, 50, 69, 57, 70, 50, 66, 52, 68, 48, 56, 53, 69, 66, 57, 53, 48, 67, 
        55, 65, 66, 49, 50, 69, 68, 69, 50, 68, 52, 49, 50, 57, 55, 56, 50, 48, 69, 54, 
        51, 55, 55, 65, 53, 70, 69, 66, 53, 54, 56, 57, 68, 52, 69, 54, 48, 51, 50, 70, 
        54, 48, 67, 52, 51, 48, 55, 52, 65, 48, 52, 67, 50, 54, 65, 66, 55, 50, 70, 53, 
        52, 66, 53, 49, 66, 66, 52, 54, 48, 53, 55, 56, 55, 56, 53, 66, 49, 57, 57, 48, 
        49, 52, 51, 49, 52, 65, 54, 53, 70, 48, 57, 48, 66, 54, 49, 70, 67, 50, 48, 49, 
        54, 57, 52, 53, 51, 66, 53, 56, 70, 67, 56, 66, 65, 52, 51, 69, 54, 55, 55, 54, 
        69, 66, 55, 69, 67, 68, 51, 49, 55, 56, 66, 53, 54, 65, 66, 48, 70, 65, 48, 54, 
        68, 68, 54, 52, 57, 54, 55, 67, 66, 49, 52, 57, 69, 53, 48, 50, 48, 49, 49, 49 };
    
    /** Component's MATLAB path */
    private static final String[] sMatlabPath = 
        { "ann/",
          "$TOOLBOXDEPLOYDIR/",
          "$TOOLBOXMATLABDIR/general/",
          "$TOOLBOXMATLABDIR/ops/",
          "$TOOLBOXMATLABDIR/lang/",
          "$TOOLBOXMATLABDIR/elmat/",
          "$TOOLBOXMATLABDIR/randfun/",
          "$TOOLBOXMATLABDIR/elfun/",
          "$TOOLBOXMATLABDIR/specfun/",
          "$TOOLBOXMATLABDIR/matfun/",
          "$TOOLBOXMATLABDIR/datafun/",
          "$TOOLBOXMATLABDIR/polyfun/",
          "$TOOLBOXMATLABDIR/funfun/",
          "$TOOLBOXMATLABDIR/sparfun/",
          "$TOOLBOXMATLABDIR/scribe/",
          "$TOOLBOXMATLABDIR/graph2d/",
          "$TOOLBOXMATLABDIR/graph3d/",
          "$TOOLBOXMATLABDIR/specgraph/",
          "$TOOLBOXMATLABDIR/graphics/",
          "$TOOLBOXMATLABDIR/uitools/",
          "$TOOLBOXMATLABDIR/strfun/",
          "$TOOLBOXMATLABDIR/imagesci/",
          "$TOOLBOXMATLABDIR/iofun/",
          "$TOOLBOXMATLABDIR/audiovideo/",
          "$TOOLBOXMATLABDIR/timefun/",
          "$TOOLBOXMATLABDIR/datatypes/",
          "$TOOLBOXMATLABDIR/verctrl/",
          "$TOOLBOXMATLABDIR/codetools/",
          "$TOOLBOXMATLABDIR/helptools/",
          "$TOOLBOXMATLABDIR/demos/",
          "$TOOLBOXMATLABDIR/timeseries/",
          "$TOOLBOXMATLABDIR/hds/",
          "$TOOLBOXMATLABDIR/guide/",
          "$TOOLBOXMATLABDIR/plottools/",
          "toolbox/local/",
          "$TOOLBOXMATLABDIR/datamanager/",
          "toolbox/compiler/" };
    
    /** Items to be added to component's class path */
    private static final String[] sClassPath = 
        {};
    
    /** Items to be added to component's lib path */
    private static final String[] sLibraryPath =
        {};
    
    /** MCR instance-specific runtime options */
    private static final String[] sApplicationOptions =
        {};
    
    /** MCR global runtime options */
    private static final String[] sRuntimeOptions = {};
    
    /** Runtime warning states */
    private static final String[] sSetWarningState = 
        { "off:MATLAB:dispatcher:nameConflict" };
    
    /** Component's preference directory */
    private static final String sComponentPrefDir = "ann_0FAE6358ECFA828BC53ACDB5EAF3B990";
    
    /** Component name */
    private static final String sComponentName = "ann";
    
    /** Pointer to native component-data structure */
    private static final NativeComponentData sComponentData = 
        new NativeComponentData(
            createComponentData(
                MWMCR.findComponentParentDirOnClassPath(
                    sComponentName, 
                    "com.g4.matlab.ann"
                )
            )
        );
    
    /** Pointer to default component options */
    private static final MWComponentOptions sDefaultComponentOptions = 
        new MWComponentOptions(
            MWCtfExtractLocation.EXTRACT_TO_CACHE, 
            new MWCtfClassLoaderSource(AnnMCRFactory.class)
        );
    
    /** Creates a native component-data structure */
    static NativePtr createComponentData(String pathToComponent)
    {
        try {
            return MWMCR.getNativeMCR().mclCreateComponentData(
                sPublicKey, 
                sComponentName, 
                "",
                sSessionKey,
                sMatlabPath,
                sClassPath,
                sLibraryPath,
                sApplicationOptions,
                sRuntimeOptions,
                sComponentPrefDir,
                pathToComponent,
                sSetWarningState
            );
        }
        catch (MWException e) {
            return NativePtr.NULL;
        }
    }
    
    private AnnMCRFactory()
    {
        // Never called.
    }
    
    public static MWMCR newInstance(MWComponentOptions componentOptions) throws MWException
    {
        if (null == componentOptions.getCtfSource()) {
            componentOptions = new MWComponentOptions(componentOptions);
            componentOptions.setCtfSource(sDefaultComponentOptions.getCtfSource());
        }
        return MWMCR.newInstance(
            sComponentData, 
            componentOptions, 
            AnnMCRFactory.class, 
            sComponentName, 
            new int[]{7,13}
        );
    }
    
    public static MWMCR newInstance() throws MWException
    {
        return newInstance(sDefaultComponentOptions);
    }
}
