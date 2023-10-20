import itertools


def calculate_total_distance(path, graph):
    total_distance = 0
    for i in range(len(path) - 1):
        total_distance += graph[path[i]][path[i + 1]]
    return total_distance


def brute_force_tsp(graph):
    num_cities = len(graph)
    cities = list(range(num_cities))
    shortest_path = None
    shortest_distance = float('inf')

    for perm in itertools.permutations(cities):
        distance = calculate_total_distance(perm + (perm[0], ), graph)
        if distance < shortest_distance:
            shortest_distance = distance
            shortest_path = perm

    return shortest_path, shortest_distance


# Example usage:
graph = [[0, 29, 20, 21],
        [29, 0, 15, 17],
        [20, 15, 0, 28],
        [21, 17, 28, 0]]

shortest_path, shortest_distance = brute_force_tsp(graph)
print("Shortest Path:", shortest_path)
print("Shortest Distance:", shortest_distance)
