package domain;

public interface AdapterCallback {
    void onItemClick(int position, int adapterIndex);
    void onItemSelected(int adapterPosition);
    void onItemDeselected(int adapterPosition);
}
