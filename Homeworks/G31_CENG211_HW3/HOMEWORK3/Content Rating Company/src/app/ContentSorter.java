package app;

import java.util.ArrayList;

/**
 *
 * @author Gökay Gülsoy
 */
public class ContentSorter<T extends Comparable> {

    public void sort(ArrayList<T> contentList) {
        int index, indexOfSmallest;
        for (index = 0; index < contentList.size() - 1; index++) {
            indexOfSmallest = indexOfSmallest(index, contentList);
            interchange(index, indexOfSmallest, contentList);
        }
    }

    // Returns the index of smallest value among 
    // list[startIndex+1],...list[size-1]
    private int indexOfSmallest(int startIndex, ArrayList<T> contentList) {
        T smallest = contentList.get(startIndex);
        int indexOfSmallest = startIndex;

        for (int index = startIndex + 1; index < contentList.size(); index++) {
            if (contentList.get(index).compareTo(smallest) < 0) {
                smallest = contentList.get(index);
                indexOfSmallest = index;
            }
        }

        return indexOfSmallest;
    }

    // precondition: i and j are legal indices for the contentList
    // postcondition: Values of list[i] and list[j] have bee interchanged
    private void interchange(int i, int j, ArrayList<T> contentList) {
        T temp;
        temp = contentList.get(i);
        contentList.set(i, contentList.get(j));
        contentList.set(j, temp);
    }

}
