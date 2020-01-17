package collectionitemselector;

import java.util.List;

public class ListItemSelector extends AbstractCollectionItemSelector {

	private List list;
	private int currentIndex = 0;
	
	public ListItemSelector(List list) {
		this.list = list;
	}
	
	@Override
	public void setCurrentIndex(int index) {
		if (index >= 0 && index < list.size()) {
			currentIndex = index;
			notifyIndexChanged();
		}
	}

	@Override
	public void setNextIndex() {
		if (currentIndex + 1 < list.size()) {
			currentIndex++;
			notifyIndexChanged();
		}
	}

	@Override
	public void setPreviousIndex() {
		if (currentIndex - 1 >= 0) {
			currentIndex--;
			notifyIndexChanged();
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

}
