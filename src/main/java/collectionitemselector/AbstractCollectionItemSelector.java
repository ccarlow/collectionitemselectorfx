package collectionitemselector;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCollectionItemSelector {
  private List<CollectionItemSelectorListener> listeners =
      new ArrayList<CollectionItemSelectorListener>();

  public abstract void setCurrentIndex(int index);

  public abstract void setNextIndex();

  public abstract void setPreviousIndex();

  public abstract int getCurrentIndex();

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
