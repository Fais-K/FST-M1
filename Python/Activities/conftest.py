import pytest

@pytest.fixture
def num_list():
    list = list(range(11))

    return list