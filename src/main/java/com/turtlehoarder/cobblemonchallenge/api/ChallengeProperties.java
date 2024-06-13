package com.turtlehoarder.cobblemonchallenge.api;

public class ChallengeProperties {
    public ChallengeProperties(int minLevel,int maxLevel,int handicapP1,int handicapP2,boolean showPreview) {
        _minLevel = minLevel;
        _maxLevel = maxLevel;
        _handicapP1 = handicapP1;
        _handicapP2 = handicapP2;
        _showPreview = showPreview;
    }
    private int _minLevel;
    private int _maxLevel;
    private int _handicapP1;
    private int _handicapP2;
    private boolean _showPreview;

    public int getMinLevel () { return _minLevel; }
    public int getMaxLevel () { return _maxLevel; }
    public int getHandicapP1 () { return _handicapP1; }
    public int getHandicapP2 () { return _handicapP2; }
    public boolean getShowPreview () { return _showPreview; }
}
