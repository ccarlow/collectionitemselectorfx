package collectionitemselector;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCollectionItemSelector {
  private List<CollectionItemSelectorListener> listeners =
      new ArrayList<CollectionItemSelectorListener>();
  protected int currentIndex;
  public static final int NO_INDEX = 0;
  public void resetCurrentIndex() {
    currentIndex = NO_INDEX;
    setNextIndex();
  }
  
  public abstract void setCurrentIndex(int index);

  public abstract void setNextIndex();

  public abstract void setPreviousIndex();

  public int getCurrentIndex() {
    return currentIndex;
  }

  public abstract int getListSize();

  public void notifyIndexChanged() {
    for (CollectionItemSelectorListener listener : listeners) {
      listener.currentIndexChanged();
    }
  }

  public void addCollectionItemSelectorListener(CollectionItemSelectorListener listener) {
    listeners.add(listener);
  }

  public void removeCollectionItemSelectorListener(CollectionItemSelectorListener listener) {
    listeners.remove(listener);
  }
}
