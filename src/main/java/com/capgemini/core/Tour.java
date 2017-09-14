package com.capgemini.core;

/**
 * Represents a boat tour
 */
public class Tour {
    private final static String ALREADY_STARTED_EXCEPTION = "Tour has already started.";
    private final static String ALREADY_STOPPED_EXCEPTION = "Tour has already stooped.";
    private final static String NOT_YET_STARTED_EXCEPTION = "Tour has not started yet.";

    /**
     * {@link #tourId} represents a tour identifier.
     * {@link #start} represents the time at which this tour started.
     * {@link #stop} represents the time at which this tour ended.
     * {@link #duration} represents the duration of the tour in ms.
     */
    public  final   int     tourId;
    public          Long    start;
    private         Long    stop;
    private         Long    duration;

    /**
     * Creates a new tour with an identifier and a start time.
     *
     * @param tourId The identifier of this tour.
     */
    public Tour(int tourId) {
        this.tourId     = tourId;
        this.start      = null;
        this.stop       = null;
        this.duration   = null;
    }

    /**
     * Gets the tour identifier.
     *
     * @return The identifier of this tour.
     */
    public int getTourId() {
        return tourId;
    }

    /**
     * Gets the time at which this tour started.
     *
     * @return The time at which this tour started. Returns null if tour has not yet started.
     */
    public Long getStart() {
        return start;
    }

    /**
     * Gets the time at which this tour ended.
     *
     * @return The time at which this tour ended. Returns null if tour has not yet ended.
     */
    public Long getStop() {
        return stop;
    }

    /**
     * Gets the duration of the tour.
     *
     * @return The duration of the tour in ms. Returns null if tour has not yet ended.
     */
    public Long getDuration() {
        return duration;
    }

    /**
     * Start the tour
     */
    protected void start() throws TourException {
        if(start != null) {
            throw new TourException(ALREADY_STARTED_EXCEPTION);
        }
        this.start = System.currentTimeMillis();
    }

    /**
     * Stop the tour
     */
    protected void stop() throws TourException {
        if(start == null) {
            throw new TourException(NOT_YET_STARTED_EXCEPTION);
        }
        if(stop != null) {
            throw new TourException(ALREADY_STOPPED_EXCEPTION);
        }
        this.stop       = System.currentTimeMillis();
        this.duration   = stop - start;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof Tour))return false;

        Tour otherTour = (Tour)other;
        return otherTour.tourId == this.tourId;
    }
}
