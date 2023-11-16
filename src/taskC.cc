#include <climits>
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Columns {
 public:
  Columns(string* names, size_t m, vector<int> min, vector<int> max,
          vector<int> left, vector<int> right)
      : names_(names), min_(min), max_(max), left_(left), right_(right) {
    for (size_t i = 0; i != m; i++) mp[names[i]] = i;
  }

  void setMin(int number, int index) {
    if (min_[index] > number) min_[index] = number;
  }

  void setMax(int number, int index) {
    if (max_[index] < number) max_[index] = number;
  }

  bool setLeft(int number, int index) {
    if (number < min_[index]) return true;
    if (number >= max_[index]) return false;
    if (number > left_[index]) left_[index] = number;
    return true;
  }

  int getLeft(int index) { return left_[index]; }

  bool setRight(int number, int index) {
    if (number > max_[index]) return true;
    if (number <= min_[index]) return false;
    if (number < right_[index]) right_[index] = number;
    return true;
  } 

  int getRight(int index) { return right_[index]; }

  int getColumn(string name) { return mp[name]; }

  bool checkQueries(size_t q) {
    bool res = true;
    for (size_t i = 0; i != q; i++) {
      string name;
      char type;
      int number;
      cin >> name >> type >> number;

      int index = mp[name];
      if ((type == '<' && !setRight(number, index)) ||
          (type == '>' && !setLeft(number, index))) {
        res = false;
        break;
      }
    }
    return res;
  }

 private:
  string* names_;
  unordered_map<string, int> mp;
  vector<int> min_;
  vector<int> max_;
  vector<int> left_;
  vector<int> right_;
};

class Table {
 public:
  Table(vector<vector<int>>& matrix, vector<long>& sumVector, Columns& columns,
        long sum)
      : matrix_(matrix), sumVector_(sumVector), columns_(columns), sum_(sum) {}

  long getRes(size_t n, size_t m, size_t q) {
    if (!columns_.checkQueries(q)) {
      return 0;
    } else {
      for (size_t i = 0; i != m; ++i) {
        if (sum_ == 0) break;
        int left = columns_.getLeft(i), right = columns_.getRight(i);
        if (left == INT_MIN && right == INT_MAX) continue;
        for (size_t j = 0; j != n; ++j) {
          if (sumVector_[j] == 0) continue;
          if (matrix_[j][i] <= left || matrix_[j][i] >= right) {
            sum_ -= sumVector_[j];
            sumVector_[j] = 0;
          }
        }
      }
    }
    return sum_;
  }

 private:
  vector<vector<int>> matrix_;
  vector<long> sumVector_;
  Columns columns_;
  long sum_;
};

int main() {
  size_t n, m, q;
  cin >> n >> m >> q;

  string names[m];
  for (size_t i = 0; i != m; ++i) cin >> names[i];
  vector<int> min(m, INT_MAX), max(m, INT_MIN);
  vector<int> left(m, INT_MIN), right(m, INT_MAX);
  Columns columns(names, m, min, max, left, right);

  vector<vector<int>> matrix(n, std::vector<int>(m));
  vector<long> sumVector(n);
  long allSum = 0;
  for (size_t i = 0; i != n; ++i) {
    long sum = 0;
    for (size_t j = 0; j != m; ++j) {
      int number;
      cin >> number;
      sum += number;
      columns.setMin(number, j);
      columns.setMax(number, j);
      matrix[i][j] = number;
    }
    sumVector[i] = sum;
    allSum += sum;
  }

  Table table(matrix, sumVector, columns, allSum);
  cout << table.getRes(n, m, q);
}