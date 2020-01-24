package collectionitemselector;

import java.util.List;

public class ListItemSelector extends AbstractCollectionItemSelector {

  private List list;
  private int currentIndex = 0;
  private List<Integer> indices;

  public ListItemSelector(List list) {
    this.list = list;
  }

  public List getList() {
    return list;
  }
  
  public void setIndices(List<Integer> indices) {
    this.indices = indices;
  }

  @Override
  public void setCurrentIndex(int index) {
    if (index > 0 && index <= list.size()) {
      currentIndex = index;
      notifyIndexChanged();
    }
  }

  @Override
  public void setNextIndex() {
    if (currentIndex + 1 <= list.size()) {
      if (indices != null) {
        for (Integer index : indices) {
          if (currentIndex < index) {
            currentIndex = index;
            break;
          }
        }
      } else {
        currentIndex++;
      }
      notifyIndexChanged();
    }
  }

  @Override
  public void setPreviousIndex() {
    if (currentIndex - 1 > 0) {
      if (indices != null) {
        for (int i = indices.size() - 1; i >= 0; i--) {
          if (currentIndex > indices.get(i)) {
            currentIndex = indices.get(i);
            break;
          }
        }
      } else {
        currentIndex--;
      }
      notifyIndexChanged();
    }
  }
  
  public void removeIndex() {
    if (indices != null && indices.size() > 0) {
      int i = -1;
      for (Integer index : indices) {
        if (currentIndex == index) {
          i++;
          break;
        }
      }
      if (i > -1) {
        indices.remove(i);
        setNextIndex();
      }
    }
  }

  @Override
  public int getCurrentIndex() {
    return currentIndex;
  }

  @Override
  public int getListSize() {
    return list.size();
  }

  @Override
  public void resetCurrentIndex() {
    setCurrentIndex(1);
  }

}
