package contents;

import workers.Worker;

/**
 *
 * @author Gökay Gülsoy
 */
public interface RatableContent {

    /**
     * interface for each content wich is either Game or Movie class and
     * implementors should provide rating calculation logic according to content
     * type
     *
     * @return rate rate value computed according to content type
     */
    public double rateContent(Worker critic);
}
