package com.dynoware.cargosafe.platform.iam.interfaces.rest.resources;

import java.util.List;

/**
 * Authenticated user resource.
 */
public record AuthenticatedUserResource(Long id, String username, String token, List<String> roles) {
}